# reserve - finds and reserves a block of 2^k locations, or reports failure, using the
# organization of the buddy system as described in Kunth
# @param size The size in bytes requested
# @return The offset in size_t from the start of the pool
def reserve(size):
	k = get_upper_k(size + sizeof(struct block_header))
	m = pool.lgsize
	j = k
	# R1 - Find nearest available block
	while (j <= m ):
		if (not_empty(pool.avail[j])):
			# R2 - Remove block from list
			block = remove_block(pool.avail[j].next)

			# R3 - Check if we are done
			if (j == k):
				block->tag = RESERVED
				return block
			else:
				# R4 - Split the block
				split_block(block)
				return reserve(size)
		else:
			j++	
	return None

# liberate - Return the specified block to the list of available blocks. As part 
#     of the liberation process, check the block's buddy to see if it can be 
#     combined with the current block.  If so, combine them, then recursively 
#     call liberate.
# @param block The block to be liberated
def liberate(block):
	# Stop liberating once we have reached the top of the pool
	if (block->kval == pool.lgsize):
		add_block(block)
		return
	# S1 - Check if buddy is available
    buddy = get_buddy(block)
	if (is_avail(buddy)):
		# S2 - Combine with Buddy and recursively call liberate()
		remove_block(buddy)
		merged = merge_blocks(block, buddy)
		liberate(merged)
	else:
		# S3 - Add the block to the list of available blocks
		add_block(block)

# get_buddy  - Return a reference to the buddy for the
#    current block.
# @param block the block whose buddy we're searching for
# @return the buddy
def get_buddy(block):
    # Calculate the offset of the block from the start of the pool
	offset = block - pool.start
	if (offset % pow(2,block->kval + 1) ) == 0):
        # The Buddy is on the upper side of this block
        buddy = block + pow(2,block->kval)
	else:
        # The Buddy is on the lower side of this block
		buddy = block - pow(2,block->kval)
	return buddy


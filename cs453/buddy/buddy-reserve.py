# reserve - finds and reserves a block of 2^k bytes, or reports failure, using the
# organization of the buddy system as described in Kunth
#
# NOTE:  The size passed to the 'initial' call of reservice should include
#          the number of bytes requested from the user + sizeof(struct block_header).
#          This ensures that the size of the block that is returned by reserve
#          is large enough to hold both the amount of space requested by the user
#          and the block header.
#
# @param size The size in bytes requested
# @return pointer to reserved block matching request or None
def reserve(size):
	k = get_upper_k(size)
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


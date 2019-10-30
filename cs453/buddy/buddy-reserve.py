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


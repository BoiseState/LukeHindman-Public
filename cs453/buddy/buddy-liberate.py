# liberate - Add the specified block to the list of available blocks. As part 
#     of the liberation process, check the block's buddy to see if it can be 
#     combined with the current block.  If so, combine them, then recursively 
#     call liberate.
# @param block The block to be liberated
def liberate(block):
	# S1 - Check if buddy is available
    buddy = get_buddy(block)
	if (is_avail(buddy)):
		# S2 - Combine with Buddy and recursively call liberate()
		remove_block(buddy)
		merged = merge_blocks(block, buddy)
		liberate(merged)
	else:
		# S3 - Add the block to the list of available blocks
		block->tag = FREE
		add_block(block)


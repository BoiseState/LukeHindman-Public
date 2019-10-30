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


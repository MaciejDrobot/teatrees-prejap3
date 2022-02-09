package com.epam.prejap.teatrees.block;

import java.util.function.Supplier;

/**
 * Single block feeds for test purposes to keep package-privacy of concrete blocks
 */
public enum SingleBlockFeed {
  H_BLOCK(HBlock::new),
  L_BLOCK(LBlock::new),
  O_BLOCK(OBlock::new),
  S_BLOCK(SBlock::new),
  Y_BLOCK(YBlock::new),
  Z_BLOCK(ZBlock::new);

  private final BlockSupplier feed;

  SingleBlockFeed(BlockSupplier feed) {
    this.feed = feed;
  }

  public BlockSupplier feed() { return feed; }
}

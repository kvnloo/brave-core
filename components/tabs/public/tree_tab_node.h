// Copyright (c) 2025 The Brave Authors. All rights reserved.
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this file,
// You can obtain one at https://mozilla.org/MPL/2.0/.

#ifndef TREE_TAB_NODE_H_
#define TREE_TAB_NODE_H_

// A class that represents metadata about a tree tab node.
class TabTreeNode {
 public:
  int height() const { return height_; }
  int level() const { return level_; }
  bool collapsed() const { return collapsed_; }

 private:
  // The level of this node in the tree. Root is level 0, its children are
  // level 1, and so on.
  int level_ = 0;

  // The height of the subtree rooted at this node. A leaf node has height 0.
  // This is used for calculating the level of nodes efficiently.
  int height_ = 0;

  // When this is true, the child tabs under this tree node are hidden.
  bool collapsed_ = false;
};

#endif  // TREE_TAB_NODE_H_

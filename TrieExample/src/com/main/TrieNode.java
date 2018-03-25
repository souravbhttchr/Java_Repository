package com.main;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	private Map<Character, TrieNode> charChild;
	private boolean isEndOfString;
	private TrieNode rootNode;
			
	public TrieNode(TrieNode root) {
		this.charChild = new HashMap<>();
		this.isEndOfString = false;
		this.rootNode = root;
	}

	public Map<Character, TrieNode> getCharChild() {
		return charChild;
	}

	public void setCharChild(Map<Character, TrieNode> charChild) {
		this.charChild = charChild;
	}

	public boolean isEndOfString() {
		return isEndOfString;
	}

	public void setEndOfString(boolean isEndOfString) {
		this.isEndOfString = isEndOfString;
	}

	public TrieNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TrieNode rootNode) {
		this.rootNode = rootNode;
	}
}

package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RolebasedUserMenu {

	@JsonProperty("MenuID")
	private int MenuID;

	@JsonProperty("parentID")
	private int parentID;

	@JsonProperty("depth")
	private int depth;

	@JsonProperty("MenuTitle")
	private String MenuTitle;

	@JsonProperty("InternalLink")
	private String InternalLink;

	@JsonProperty("NodeID")
	private int NodeID;

	@JsonProperty("ImageURL")
	private String ImageURL;

	@JsonProperty("Lineage")
	private String Lineage;

	@JsonProperty("TopParentIds")
	private int TopParentIds;

	@JsonProperty("LinkedPages")
	private String LinkedPages;

	@JsonProperty("SequenceNo")
	private int SequenceNo;

	@JsonProperty("DocumentCode")
	private String DocumentCode;

	public RolebasedUserMenu(int menuID, int parentID, int depth, String menuTitle, String internalLink, int nodeID,
			String imageURL, String lineage, int topParentIds, String linkedPages, int sequenceNo,
			String documentCode) {
		super();
		this.MenuID = menuID;
		this.parentID = parentID;
		this.depth = depth;
		this.MenuTitle = menuTitle;
		this.InternalLink = internalLink;
		this.NodeID = nodeID;
		this.ImageURL = imageURL;
		this.Lineage = lineage;
		this.TopParentIds = topParentIds;
		this.LinkedPages = linkedPages;
		this.SequenceNo = sequenceNo;
		this.DocumentCode = documentCode;
	}

	public RolebasedUserMenu() {
		super();
	}

	// Getters and Setters
	public int getMenuID() {
		return MenuID;
	}

	public void setMenuID(int menuID) {
		MenuID = menuID;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getMenuTitle() {
		return MenuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		MenuTitle = menuTitle;
	}

	public String getInternalLink() {
		return InternalLink;
	}

	public void setInternalLink(String internalLink) {
		InternalLink = internalLink;
	}

	public int getNodeID() {
		return NodeID;
	}

	public void setNodeID(int nodeID) {
		NodeID = nodeID;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public String getLineage() {
		return Lineage;
	}

	public void setLineage(String lineage) {
		Lineage = lineage;
	}

	public int getTopParentIds() {
		return TopParentIds;
	}

	public void setTopParentIds(int topParentIds) {
		TopParentIds = topParentIds;
	}

	public String getLinkedPages() {
		return LinkedPages;
	}

	public void setLinkedPages(String linkedPages) {
		LinkedPages = linkedPages;
	}

	public int getSequenceNo() {
		return SequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		SequenceNo = sequenceNo;
	}

	public String getDocumentCode() {
		return DocumentCode;
	}

	public void setDocumentCode(String documentCode) {
		DocumentCode = documentCode;
	}

}

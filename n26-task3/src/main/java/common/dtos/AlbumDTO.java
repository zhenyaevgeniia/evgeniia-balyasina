package common.dtos;

public class AlbumDTO {

	private String titleInBold;
	private String titleFull;
	private String artist;
	private boolean isThumbnailVisible;

	public String getTitleInBold() {
		return titleInBold;
	}

	public void setTitleInBold(String titleInBold) {
		this.titleInBold = titleInBold;
	}

	public String getTitleFull() {
		return titleFull;
	}

	public void setTitleFull(String titleFull) {
		this.titleFull = titleFull;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public boolean isThumbnailVisible() {
		return isThumbnailVisible;
	}

	public void setThumbnailVisible(boolean thumbnailVisible) {
		isThumbnailVisible = thumbnailVisible;
	}
}

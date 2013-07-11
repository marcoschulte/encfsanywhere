package de.voot.encfsanywhere.client.model;

public class DownloadStatus {
	private String path;
	private float progress;

	public DownloadStatus(String path) {
		this.path = path;
		progress = 0f;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

}

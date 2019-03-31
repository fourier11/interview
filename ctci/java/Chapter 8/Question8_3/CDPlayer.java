package Question8_3;

/**
 * CD播放器只能放一张CD
 */
public class CDPlayer {
	private Playlist p;
	private CD c;
	
	public Playlist getPlaylist() { return p; }
	public void setPlaylist(Playlist p) { this.p = p; }
	public CD getCD() { return c; }
	public void setCD(CD c) { this.c = c; }
	
	public CDPlayer(Playlist p) { this.p = p; }
	public CDPlayer(CD c, Playlist p) { 
		this.p = p;
		this.c = c;
	}

	public CDPlayer(CD c){ this.c = c; }
	public void playSong(Song s) {  }
}

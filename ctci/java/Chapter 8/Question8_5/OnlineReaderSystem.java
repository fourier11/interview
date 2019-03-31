package Question8_5;

/**
 * 设计在线图书阅读器系统的数据结构
 * 功能：
 * 用户成员资格的建立和延长期限
 * 搜索图书数据库
 * 阅读书籍
 * 同一时间只能由一个活跃用户
 * 该用户一次只能看一本书
 * 
 * OnlineReaderSystem 类是程序主体，需要实现存放图书信息，管理用户，刷新显示页面。为了防止让整个类太笨重，
 * 将这些组件拆分为 Library，UserManager，Display几个类
 */
public class OnlineReaderSystem {
	private Library library;
	private UserManager userManager;
	private Display display;
	
	private Book activeBook;
	private User activeUser;
	
	public OnlineReaderSystem() {
		userManager = new UserManager();
		library = new Library();
		display = new Display();
	}
	
	public Library getLibrary() {
		return library;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public Book getActiveBook() {
		return activeBook;
	}
	
	public void setActiveBook(Book book) {
		display.displayBook(book);
		activeBook = book;
	}
	
	public User getActiveUser() {
		return activeUser;
	}
	
	public void setActiveUser(User user) {
		activeUser = user;
		display.displayUser(user);
	}
}

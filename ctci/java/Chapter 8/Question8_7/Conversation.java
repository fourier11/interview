package Question8_7;

import java.util.ArrayList;

/**
 * 设计一个聊天服务器，要求给出各种后台组件、类和方法的细节。并说明其中最难解决的问题是什么？
 * 核心功能：添加用户、创建对话、更新状态
 * 聊天系统支持群组聊天，一对一聊天。
 * TODO:这道题还是比较复杂的，抽空再看看
 */
public abstract class Conversation {
	protected ArrayList<User> participants = new ArrayList<User>();
	protected int id;
	protected ArrayList<Message> messages = new ArrayList<Message>();
	
	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	public boolean addMessage(Message m) {
		messages.add(m);
		return true;
	}
	
	public int getId() {
		return id;
	}
}

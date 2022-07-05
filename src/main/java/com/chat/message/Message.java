package com.chat.message;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.chat.User.User;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMessage;
	
    private Date messageDate;
    
    private String messageContent;
    
    private String media;
        
    @OneToOne
    private User sender;
    
    @OneToOne
    private User receivers;
     
    private MessageStatus statut;

	/**
	 * @param idMessage
	 * @param messageDate
	 * @param messageContent
	 * @param media
	 * @param sender
	 * @param receivers
	 * @param statut
	 */
	public Message(long idMessage, Date messageDate, String messageContent, String media, User sender, User receivers,
			MessageStatus statut) {
		super();
		this.idMessage = idMessage;
		this.messageDate = messageDate;
		this.messageContent = messageContent;
		this.media = media;
		this.sender = sender;
		this.receivers = receivers;
		this.statut = statut;
	}

	/**
	 * 
	 */
	public Message() {
		super();
	}

	/**
	 * @return the idMessage
	 */
	public long getIdMessage() {
		return idMessage;
	}

	/**
	 * @param idMessage the idMessage to set
	 */
	public void setIdMessage(long idMessage) {
		this.idMessage = idMessage;
	}

	/**
	 * @return the messageDate
	 */
	public Date getMessageDate() {
		return messageDate;
	}

	/**
	 * @param messageDate the messageDate to set
	 */
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	/**
	 * @return the messageContent
	 */
	public String getMessageContent() {
		return messageContent;
	}

	/**
	 * @param messageContent the messageContent to set
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * @return the receivers
	 */
	public User getReceivers() {
		return receivers;
	}

	/**
	 * @param receivers the receivers to set
	 */
	public void setReceivers(User receivers) {
		this.receivers = receivers;
	}

	/**
	 * @return the statut
	 */
	public MessageStatus getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(MessageStatus statut) {
		this.statut = statut;
	}

}

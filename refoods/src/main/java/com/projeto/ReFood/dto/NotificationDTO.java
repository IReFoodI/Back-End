package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.UserNotification;
import lombok.Data;
import java.util.Date;

@Data
public class NotificationDTO {
    
    private int id_notification;
    private String msg_notification;
    private boolean msg_read;
    private Date send_date;
    
    private UserNotification usersNotifications;

}

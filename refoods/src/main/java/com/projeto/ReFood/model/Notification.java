package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="notifications")
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_notification;
    @Column
    private String msg_notification;
    @Column(nullable = false)
    private boolean msg_read;
    @Column(nullable = false)
    private Date send_date;
    
//    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
//    private User fk_id_user;

    // @OneToMany(mappedBy = "fk_id_notification")
    // private Set<UserNotification> usersNotifications;

}

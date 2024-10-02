package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserNotificationId implements Serializable {
    
    @Column(name = "fk_id_user")
    private int fk_id_user;
    
    @Column(name = "fk_id_notification")
    private int fk_id_notification;

    public UserNotificationId() {}

    public UserNotificationId(int fkIdUser, int fkIdNotification) {
        this.fk_id_user = fkIdUser;
        this.fk_id_notification = fkIdNotification;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNotificationId that = (UserNotificationId) o;
        return fk_id_user == that.fk_id_user &&
                fk_id_notification == that.fk_id_notification;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fk_id_user, fk_id_notification);
    }
}

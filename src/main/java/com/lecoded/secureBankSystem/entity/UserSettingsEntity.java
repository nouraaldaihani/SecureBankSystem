package com.lecoded.secureBankSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_settings")

public class UserSettingsEntity {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private boolean receiveNewsLetter;

    private String preferredLanguage;

    public boolean isReceiveNewsLetter() {
        return receiveNewsLetter;
    }

    public void setReceiveNewsLetter(boolean receiveNewsLetter) {
        this.receiveNewsLetter = receiveNewsLetter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}

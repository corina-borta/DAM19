package org.scrum.client;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class client {

   private Integer IDClient;
   private String NumeClient;
   private  Integer Telefon;
   private String Email;


   public client(Integer idClient, String numeClient, String telefon, String email) {
        this.IDClient = IDClient;
        this.NumeClient = NumeClient;
        this.Telefon = Telefon;
        this.Email = Email;
    }

    public Integer getIDClient() {
        return IDClient;
    }

    public void setIDClient(Integer IDClient) {
        this.IDClient = IDClient;
    }

    public String getNumeClient() {
        return NumeClient;
    }

    public void setNumeClient(String numeClient) {
        NumeClient = numeClient;
    }

    public Integer getTelefon() {
        return Telefon;
    }

    public void setTelefon(Integer telefon) {
        Telefon = telefon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@NamedQueries({
        // メールアドレスの重複チェック
        @NamedQuery(name = "checkRegisteredMailAddress", query = "SELECT COUNT(u) FROM User AS u WHERE u.mail_address= :mail_address"),
        // ログイン時のメールアドレスとパスワードチェック
        @NamedQuery(name = "checkLoginMailAddressAndPassword", query = "SELECT u FROM User AS u WHERE u.mail_address= :mail_address AND u.password= :pass"

        )

})
// エンティティ
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mail_address", nullable = false)
    private String mail_address;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "icon", length = 255, nullable = false)
    private String icon;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "favorites", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> my_favorite_post_list;

    // ゲッターとセッター
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail_address() {
        return mail_address;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Post> getMy_favorite_post_list() {
        return my_favorite_post_list;
    }

    public void setMy_favorite_post_list(List<Post> my_favorite_post_list) {
        this.my_favorite_post_list = my_favorite_post_list;
    }

}

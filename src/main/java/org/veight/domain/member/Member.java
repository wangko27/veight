package org.veight.domain.member;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.veight.domain.ABaseEntity;
import org.veight.domain.Song;

/**
 * 会员 实体类
 *
 * @author Administrator
 * @时间 2014-6-29 上午9:05:07
 * @开发团队 845885222@qq.com
 */
@Entity
@Table(name = "v_member")
public class Member extends ABaseEntity {

    private static final long serialVersionUID = 1480440988433767774L;

    public static final String LOGIN_MEMBER_ID_SESSION_NAME = "loginMemberId";// 保存登录会员ID的Session名称
    public static final String LOGIN_MEMBER_USERNAME_COOKIE_NAME = "loginMemberUsername";// 保存登录会员用户名的Cookie名称
    public static final String LOGIN_REDIRECTION_URL_SESSION_NAME = "redirectionUrl";// 保存登录来源URL的Session名称
    public static final String PASSWORD_RECOVER_KEY_SEPARATOR = "_";// 密码找回Key分隔符
    public static final int PASSWORD_RECOVER_KEY_PERIOD = 10080;// 密码找回Key有效时间（单位：分钟）

    private String username;// 用户名
    private String password;// 密码
    private String email;// E-mail
    private String safeQuestion;// 密码保护问题
    private String safeAnswer;// 密码保护问题答案
    private Integer point;// 积分
    private Boolean isAccountEnabled;// 账号是否启用
    private Boolean isAccountLocked;// 账号是否锁定
    private Integer loginFailureCount;// 连续登录失败的次数
    private Date lockedDate;// 账号锁定日期
    private String registerIp;// 注册IP
    private String loginIp;// 最后登录IP
    private Date loginDate;// 最后登录日期
    private String passwordRecoverKey;// 密码找回Key

    private MemberRank memberRank;// 会员等级
    private Set<Song> favoriteSongSet;// 收藏夹

    @Column(updatable = false, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSafeQuestion() {
        return safeQuestion;
    }

    public void setSafeQuestion(String safeQuestion) {
        this.safeQuestion = safeQuestion;
    }

    public String getSafeAnswer() {
        return safeAnswer;
    }

    public void setSafeAnswer(String safeAnswer) {
        this.safeAnswer = safeAnswer;
    }

    @Column(nullable = false)
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Column(nullable = false)
    public Boolean getIsAccountEnabled() {
        return isAccountEnabled;
    }

    public void setIsAccountEnabled(Boolean isAccountEnabled) {
        this.isAccountEnabled = isAccountEnabled;
    }

    @Column(nullable = false)
    public Boolean getIsAccountLocked() {
        return isAccountLocked;
    }

    public void setIsAccountLocked(Boolean isAccountLocked) {
        this.isAccountLocked = isAccountLocked;
    }

    @Column(nullable = false)
    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getPasswordRecoverKey() {
        return passwordRecoverKey;
    }

    public void setPasswordRecoverKey(String passwordRecoverKey) {
        this.passwordRecoverKey = passwordRecoverKey;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    public MemberRank getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(MemberRank memberRank) {
        this.memberRank = memberRank;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "v_member_favorite_song")
    @OrderBy("name desc")
    public Set<Song> getFavoriteSongSet() {
        return favoriteSongSet;
    }

    public void setFavoriteSongSet(Set<Song> favoriteSongSet) {
        this.favoriteSongSet = favoriteSongSet;
    }

}

package com.cxyzj.cxyzjback.Data.User.front;

import com.cxyzj.cxyzjback.Bean.User.User;
import com.cxyzj.cxyzjback.Catch.RoleList;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author 夏
 * @Date 13:23 2018/8/28
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class OtherDetails extends UserData {

    private String user_id;
    private String nickname;
    private String head_url;
    private String role;
    private String introduce;
    private String bg_url;
    private String theme_color;
    private int gender;
    private int attentions;
    private int fans;
    private int articles;
    private int discussions;
    private int comments;
    private int status_id;
    private boolean is_followed;

    public OtherDetails(User user) {
        this(user, false);
    }

    public OtherDetails(User user, boolean is_followed) {
        this.user_id = user.getUserId();
        this.nickname = user.getNickname();
        this.head_url = user.getHeadUrl();
        this.role = RoleList.getRoles().getRole(user.getRoleId());
        this.introduce = user.getIntroduce();
        this.gender = user.getGender();
        this.attentions = user.getAttentions();
        this.fans = user.getFans();
        this.articles = user.getArticles();
        this.discussions = user.getDiscussions();
        this.comments = user.getComments();
        this.is_followed = is_followed;
        this.bg_url = user.getBgUrl();
        this.theme_color = user.getThemeColor();
        this.status_id = user.getStatusId();
    }

}

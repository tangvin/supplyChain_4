package cn.com.edzleft.entity;

/**
 * gyl_setting
 * 我的设置
 */
public class Settings {
    private Integer settingId;
    /**
     * 手机短信
     */
    private Integer shortMessage;
    /**
     * 邮箱
     */
    private Integer email;
    /**
     * 用户id
     */
    private Integer userId;

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public Integer getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(Integer shortMessage) {
        this.shortMessage = shortMessage;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Settings settings = (Settings) o;

        if (settingId != null ? !settingId.equals(settings.settingId) : settings.settingId != null) return false;
        if (shortMessage != null ? !shortMessage.equals(settings.shortMessage) : settings.shortMessage != null)
            return false;
        if (email != null ? !email.equals(settings.email) : settings.email != null) return false;
        return userId != null ? userId.equals(settings.userId) : settings.userId == null;
    }

    @Override
    public int hashCode() {
        int result = settingId != null ? settingId.hashCode() : 0;
        result = 31 * result + (shortMessage != null ? shortMessage.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "settingId=" + settingId +
                ", shortMessage=" + shortMessage +
                ", email=" + email +
                ", userId=" + userId +
                '}';
    }
}
package vanskarner.android.communutilidades.iu.lib.retro.model;

public class UserResponse{
    private int codeStatus;
    private String message;
    private int userId;
    private int id;
    private String title;
    private String body;

    public UserResponse(int codeStatus, String message, int userId, int id, String title, String body) {
        this.codeStatus = codeStatus;
        this.message = message;
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

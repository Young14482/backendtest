package co.kr.metacoding.backendtest.user;

import lombok.Data;

public class UserRequest {
    @Data
    public static class UserUpdateDTO {
        public String name;
    }
}

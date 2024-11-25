package co.kr.metacoding.backendtest.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class UserInfoDTO {
        private int id;
        private String name;

        public UserInfoDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }

    @Data
    public static class UserInsertDTO {
        private int id;

        public UserInsertDTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class UserUpdatedDTO {
       private int id;
       private String name;

       public UserUpdatedDTO(User user) {
           this.id = user.getId();
           this.name = user.getName();
       }
    }
}

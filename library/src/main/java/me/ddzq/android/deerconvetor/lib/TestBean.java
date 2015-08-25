package me.ddzq.android.deerconvetor.lib;

import me.ddzq.android.deerconvetor.lib.anno.GenericType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzq on 15/8/24.
 */
public class TestBean {

    @GenericType(instantiate = ArrayList.class)
    private List<MomentsEntity> moments;
    private String error_msg;
    private int error_code;
    private int return_code;

    public void setMoments(List<MomentsEntity> moments) {
        this.moments = moments;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReturn_code(int return_code) {
        this.return_code = return_code;
    }

    public List<MomentsEntity> getMoments() {
        return moments;
    }

    public String getError_msg() {
        return error_msg;
    }

    public int getError_code() {
        return error_code;
    }

    public int getReturn_code() {
        return return_code;
    }

    public static class MomentsEntity {
        /**
         * images : ["9631d157186ae19f8184c755e561576f"]
         * comments : []
         * is_owner : 1
         * thumbups : [{"user_avatar":"url","user_id":"2","created_at":"1440472104892","thumbup_id":"55dbdc2b0442228b5246c6d2","user_display_name":"hello world"}]
         * resource_type : 0
         * created_at : 1440472082352
         * label_type : 1
         * video : null
         * content :
         * creator_role : 1
         * already_sent_gift : 1
         * moment_id : 55dbdc140442228b5246c6d1
         * pos : 1097803
         * creator_id : 2
         * creator_display_name : hello world
         * already_thumbup : 1
         * creator_avatar : fdsafdsafds
         */
        @GenericType(instantiate = ArrayList.class)
        private List<String> images;
        private String is_owner;
        @GenericType(instantiate = ArrayList.class)
        private List<ThumbupsEntity> thumbups;
        private String resource_type;
        private String created_at;
        private String label_type;
        private String video;
        private String content;
        private String creator_role;
        private String already_sent_gift;
        private String moment_id;
        private String pos;
        private String creator_id;
        private String creator_display_name;
        private String already_thumbup;
        private String creator_avatar;

        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setIs_owner(String is_owner) {
            this.is_owner = is_owner;
        }

        public void setThumbups(List<ThumbupsEntity> thumbups) {
            this.thumbups = thumbups;
        }

        public void setResource_type(String resource_type) {
            this.resource_type = resource_type;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setLabel_type(String label_type) {
            this.label_type = label_type;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreator_role(String creator_role) {
            this.creator_role = creator_role;
        }

        public void setAlready_sent_gift(String already_sent_gift) {
            this.already_sent_gift = already_sent_gift;
        }

        public void setMoment_id(String moment_id) {
            this.moment_id = moment_id;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public void setCreator_id(String creator_id) {
            this.creator_id = creator_id;
        }

        public void setCreator_display_name(String creator_display_name) {
            this.creator_display_name = creator_display_name;
        }

        public void setAlready_thumbup(String already_thumbup) {
            this.already_thumbup = already_thumbup;
        }

        public void setCreator_avatar(String creator_avatar) {
            this.creator_avatar = creator_avatar;
        }

        public List<String> getImages() {
            return images;
        }

        public String getIs_owner() {
            return is_owner;
        }

        public List<ThumbupsEntity> getThumbups() {
            return thumbups;
        }

        public String getResource_type() {
            return resource_type;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getLabel_type() {
            return label_type;
        }

        public String getVideo() {
            return video;
        }

        public String getContent() {
            return content;
        }

        public String getCreator_role() {
            return creator_role;
        }

        public String getAlready_sent_gift() {
            return already_sent_gift;
        }

        public String getMoment_id() {
            return moment_id;
        }

        public String getPos() {
            return pos;
        }

        public String getCreator_id() {
            return creator_id;
        }

        public String getCreator_display_name() {
            return creator_display_name;
        }

        public String getAlready_thumbup() {
            return already_thumbup;
        }

        public String getCreator_avatar() {
            return creator_avatar;
        }

        public static class ThumbupsEntity {
            /**
             * user_avatar : url
             * user_id : 2
             * created_at : 1440472104892
             * thumbup_id : 55dbdc2b0442228b5246c6d2
             * user_display_name : hello world
             */
            private String user_avatar;
            private String user_id;
            private String created_at;
            private String thumbup_id;
            private String user_display_name;

            public void setUser_avatar(String user_avatar) {
                this.user_avatar = user_avatar;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public void setThumbup_id(String thumbup_id) {
                this.thumbup_id = thumbup_id;
            }

            public void setUser_display_name(String user_display_name) {
                this.user_display_name = user_display_name;
            }

            public String getUser_avatar() {
                return user_avatar;
            }

            public String getUser_id() {
                return user_id;
            }

            public String getCreated_at() {
                return created_at;
            }

            public String getThumbup_id() {
                return thumbup_id;
            }

            public String getUser_display_name() {
                return user_display_name;
            }

            @Override
            public String toString() {
                return "ThumbupsEntity{" +
                        "created_at='" + created_at + '\'' +
                        ", user_avatar='" + user_avatar + '\'' +
                        ", user_id='" + user_id + '\'' +
                        ", thumbup_id='" + thumbup_id + '\'' +
                        ", user_display_name='" + user_display_name + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "MomentsEntity{" +
                    "already_sent_gift='" + already_sent_gift + '\'' +
                    ", images=" + images +
                    ", is_owner='" + is_owner + '\'' +
                    ", thumbups=" + thumbups +
                    ", resource_type='" + resource_type + '\'' +
                    ", created_at='" + created_at + '\'' +
                    ", label_type='" + label_type + '\'' +
                    ", video='" + video + '\'' +
                    ", content='" + content + '\'' +
                    ", creator_role='" + creator_role + '\'' +
                    ", moment_id='" + moment_id + '\'' +
                    ", pos='" + pos + '\'' +
                    ", creator_id='" + creator_id + '\'' +
                    ", creator_display_name='" + creator_display_name + '\'' +
                    ", already_thumbup='" + already_thumbup + '\'' +
                    ", creator_avatar='" + creator_avatar + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "error_code=" + error_code +
                ", moments=" + moments +
                ", error_msg='" + error_msg + '\'' +
                ", return_code=" + return_code +
                '}';
    }
}

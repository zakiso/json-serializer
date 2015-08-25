package me.ddzq.android.deerconvetor.lib;

import me.ddzq.android.deerconvetor.lib.anno.GenericType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzq on 15/8/24.
 */
public class TestBean {


    /**
     * moments : [{"images":["9631d157186ae19f8184c755e561576f"],"comments":[],"is_owner":"1","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440472104892","thumbup_id":"55dbdc2b0442228b5246c6d2","user_display_name":"hello world"}],"resource_type":"0","created_at":"1440472082352","label_type":"1","video":null,"content":"","creator_role":"1","already_sent_gift":"1","moment_id":"55dbdc140442228b5246c6d1","pos":"1097803","creator_id":"2","creator_display_name":"hello world","already_thumbup":"1","creator_avatar":"fdsafdsafds"},{"images":["296e7085e4451999bbb7597728dd0e10","b1c769249129ded4fac53553341697f3"],"comments":[],"is_owner":"1","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440472052090","thumbup_id":"55dbdbf60442228b5246c6d0","user_display_name":"hello world"}],"resource_type":"0","created_at":"1440472030994","label_type":"1","video":null,"content":"","creator_role":"1","already_sent_gift":"1","moment_id":"55dbdbe10442228b5246c6cf","pos":"1097802","creator_id":"2","creator_display_name":"hello world","already_thumbup":"1","creator_avatar":"fdsafdsafds"},{"images":["296e7085e4451999bbb7597728dd0e10","ebb23b48f85f286a1803c1058c0e54bc"],"comments":[],"is_owner":"1","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440471992763","thumbup_id":"55dbdbbb0442228b5246c6ce","user_display_name":"hello world"}],"resource_type":"0","created_at":"1440471961300","label_type":"1","video":null,"content":"","creator_role":"1","already_sent_gift":"1","moment_id":"55dbdb9b0442228b5246c6cd","pos":"1097801","creator_id":"2","creator_display_name":"hello world","already_thumbup":"1","creator_avatar":"fdsafdsafds"},{"images":["296e7085e4451999bbb7597728dd0e10","b1c769249129ded4fac53553341697f3"],"comments":[],"is_owner":"1","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440471923291","thumbup_id":"55dbdb750442228b5246c6cc","user_display_name":"hello world"}],"resource_type":"0","created_at":"1440471902002","label_type":"1","video":null,"content":"","creator_role":"1","already_sent_gift":"1","moment_id":"55dbdb600442228b5246c6cb","pos":"1097800","creator_id":"2","creator_display_name":"hello world","already_thumbup":"1","creator_avatar":"fdsafdsafds"},{"images":["296e7085e4451999bbb7597728dd0e10","b1c769249129ded4fac53553341697f3"],"comments":[],"is_owner":"1","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440471836690","thumbup_id":"55dbdb1f0442228b5246c6ca","user_display_name":"hello world"}],"resource_type":"0","created_at":"1440471813807","label_type":"1","video":null,"content":"","creator_role":"1","already_sent_gift":"1","moment_id":"55dbdb080442228b5246c6c9","pos":"1097799","creator_id":"2","creator_display_name":"hello world","already_thumbup":"1","creator_avatar":"fdsafdsafds"},{"images":["f9dd6de5ef6410972a660e89505f423c","cf3eeb1da5813d6a7cdc36be45d9bb50"],"comments":[],"is_owner":"1","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440471490773","thumbup_id":"55dbd9c50442228b5246c6c7","user_display_name":"hello world"}],"resource_type":"0","created_at":"1440471478059","label_type":"1","video":null,"content":"","creator_role":"1","already_sent_gift":"1","moment_id":"55dbd9b80442228b5246c6c6","pos":"1097798","creator_id":"2","creator_display_name":"hello world","already_thumbup":"1","creator_avatar":"fdsafdsafds"},{"images":["e8918b3c7452ae6afd9247f702166a0e","a90b56961f6ceb26bba14e26d68fdbcc"],"comments":[],"is_owner":"0","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440471405026","thumbup_id":"55dbd96f0442228b5246c6c5","user_display_name":"abc"}],"resource_type":"0","created_at":"1440471134778","label_type":"0","video":null,"content":"发挥很好","creator_role":"0","already_sent_gift":"1","moment_id":"55dbd8610442228b5246c6c4","pos":"1097797","creator_id":"1","creator_display_name":"abc","already_thumbup":"1","creator_avatar":"abc"},{"images":["a90b56961f6ceb26bba14e26d68fdbcc","6b34f46567bf7a6d92d6e01131eb9170"],"comments":[],"is_owner":"0","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440477542563","thumbup_id":"55dbf1690442228b5246c6d3","user_display_name":"abc"}],"resource_type":"0","created_at":"1440470974415","label_type":"0","video":null,"content":"风格化","creator_role":"0","already_sent_gift":"1","moment_id":"55dbd7c00442228b5246c6c3","pos":"1097796","creator_id":"1","creator_display_name":"abc","already_thumbup":"1","creator_avatar":"abc"},{"images":["a90b56961f6ceb26bba14e26d68fdbcc","6b34f46567bf7a6d92d6e01131eb9170"],"comments":[],"is_owner":"0","thumbups":[{"user_avatar":"url","user_id":"2","created_at":"1440477542563","thumbup_id":"55dbf1690442228b5246c6d3","user_display_name":"abc"}],"resource_type":"0","created_at":"1440470974415","label_type":"0","video":null,"content":"风格化","creator_role":"0","already_sent_gift":"1","moment_id":"55dbd7c00442228b5246c6c3","pos":"1097796","creator_id":"1","creator_display_name":"abc","already_thumbup":"1","creator_avatar":"abc"},{"images":["863936c063af5553300ee67100720350","a90b56961f6ceb26bba14e26d68fdbcc","6b34f46567bf7a6d92d6e01131eb9170","e8918b3c7452ae6afd9247f702166a0e"],"comments":[],"is_owner":"0","thumbups":[],"resource_type":"0","created_at":"1440470923019","label_type":"0","video":null,"content":"法国哈哈","creator_role":"0","already_sent_gift":"1","moment_id":"55dbd78d0442228b5246c6c2","pos":"1097795","creator_id":"1","creator_display_name":"abc","already_thumbup":"0","creator_avatar":"abc"}]
     * error_msg :
     * error_code : 0
     * return_code : 0
     */
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

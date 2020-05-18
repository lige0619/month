package com.bawei.lige.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class ResultEntity implements Serializable{
        private String reason;
        private Integer code;
        private Object result;

        public ResultEntity() {

        }

        public ResultEntity(String reason, Integer code, Object result) {
            this.reason = reason;
            this.code = code;
            this.result = result;
        }

        public static com.bawei.lige.entity.ResultEntity ok(Object result) {
            return new com.bawei.lige.entity.ResultEntity("success", 10001, result);
        }

        public static com.bawei.lige.entity.ResultEntity error() {
            return new com.bawei.lige.entity.ResultEntity("error", 10002, null);
        }

        public static com.bawei.lige.entity.ResultEntity error(Integer code, Object result) {
            return new com.bawei.lige.entity.ResultEntity("error", code, result);
        }

}

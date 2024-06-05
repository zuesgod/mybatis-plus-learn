package com.zues.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class UserEntity {

    private Long id;

    private String name;

    private Integer age;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer isDeleted;
}

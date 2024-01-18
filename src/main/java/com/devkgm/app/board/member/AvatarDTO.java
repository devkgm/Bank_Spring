package com.devkgm.app.board.member;

import com.devkgm.app.board.FileDTO;

public class AvatarDTO extends FileDTO {
    private Long member_id;

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }
}

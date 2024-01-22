package com.devkgm.app.member;

import com.devkgm.app.util.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private FileManager fileManager;

    public int update(MemberDTO memberDTO, MultipartFile file) throws Exception {
        int result = memberDAO.update(memberDTO);

        if (!file.isEmpty()) {
            AvatarDTO avatarDTO = new AvatarDTO();
            String fileName = fileManager.saveFile("/resources/upload/member", file);
            String originName = file.getOriginalFilename();

            avatarDTO.setMember_id(memberDTO.getId());
            avatarDTO.setName(fileName);
            avatarDTO.setOrigin_nm(originName);

            result = memberDAO.addAvatar(avatarDTO);
        }
        return result;
    }

    public MemberDTO getDetail(MemberDTO memberDTO) throws Exception {
        System.out.println(memberDTO.getUsername());
        MemberDTO m = memberDAO.getDetail(memberDTO);
        System.out.println(m.getPassword() + memberDTO.getPassword());
        if (m != null) {
            if (m.getPassword().equals(memberDTO.getPassword())) {
                return m;
            } else {
                m = null;
            }
        }
        return m;
    }

    public int join(MemberDTO memberDTO, MultipartFile file) throws Exception {
        int result = memberDAO.join(memberDTO);
        if (!file.isEmpty()) {
            AvatarDTO avatarDTO = new AvatarDTO();
            String fileName = fileManager.saveFile("/resources/upload/member", file);
            String originName = file.getOriginalFilename();

            avatarDTO.setMember_id(memberDTO.getId());
            avatarDTO.setName(fileName);
            avatarDTO.setOrigin_nm(originName);

            result = memberDAO.addAvatar(avatarDTO);
        }
        return result;
    }

    public MemberDTO getMemberInfo() throws Exception {
        return memberDAO.getMemberInfo();
    }
}

package xin.ucode.MapperTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import xin.ucode.sys.domain.User;
import xin.ucode.sys.mapper.UserMapper;

import java.util.List;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestBc(){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode =bCryptPasswordEncoder.encode("1234");
        String encode2 =bCryptPasswordEncoder.encode("1234");
        String encode3=bCryptPasswordEncoder.encode(encode2);
        System.out.println(encode);
        System.out.println(encode2);
        System.out.println(encode3);
        System.out.println(bCryptPasswordEncoder.matches("1234",encode));
        System.out.println(bCryptPasswordEncoder.matches("1234",encode2));
        System.out.println(bCryptPasswordEncoder.matches("1234",encode3));
        System.out.println(bCryptPasswordEncoder.matches(encode2,encode3));
    }
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    static String username;
    @Autowired
    MemberRepository memberRepository;

    @BeforeAll
    public static void setUpData(@Autowired MemberRepository memberRepository){
        Member member = new Member("Ömer", "1234", "a@.dk", "Ömer", "Mert", "vej", "København", 2450, true, 1);
        memberRepository.save(member);
        username = member.getUsername();
    }

    @Test
    public void findByUsername(){
        Member found = memberRepository.findByUsername(username);
        assertEquals(username, found.getUsername());
    }

    @Test
    public void updateMember(){
            int antal = (int) memberRepository.count();

            memberRepository.delete(memberRepository.findByUsername(username));

            assertEquals(antal - 1, 0);

    }
}
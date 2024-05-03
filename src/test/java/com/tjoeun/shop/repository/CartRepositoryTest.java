package com.tjoeun.shop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tjoeun.shop.dto.MemberDto;
import com.tjoeun.shop.entity.Cart;
import com.tjoeun.shop.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
// @Transactional
class CartRepositoryTest {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Member insertMember() {
		
		MemberDto memberDto = MemberDto.builder()
				                           .name("윤봉길")
				                           .email("yoon@tjoeun.com")
				                           .password("54126897")
				                           .address("원당")
				                           .build();
		
		Member member = Member.createMember(memberDto, passwordEncoder);
		return member;
	}

	@Test
	@DisplayName("장바구니 테스트")
	public void findCartAndMemberTest() {
		/*
		  Member Entity 클래스의 member_id 와
		  Cart
		*/
		Member member = insertMember();
		
		log.info(">>>>>>>>>>>>>>>> member (Entity) : " + member);
		
		Member savedMember = memberRepository.save(member);
		Member foundMember = memberRepository.findById(savedMember.getId())
                                         .orElseThrow(EntityNotFoundException::new);
		
	  log.info(">>>>>>>>>>>>>>>> foundMember : " + foundMember);
		
		
		Cart cart = new Cart();
		cart.setMember(member);
		
		log.info(">>>>>>>>>>>>>>>> cart (Entity) : " + cart);
		
		Cart savedCart = cartRepository.save(cart);
		Cart foundCart = cartRepository.findById(savedCart.getId())
		                               .orElseThrow(EntityNotFoundException::new);
		
		log.info(">>>>>>>>>>>>>>>> foundCart : " + foundCart);
		
		assertEquals(foundCart.getMember().getId(), foundMember.getId());

	}

}

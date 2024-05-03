package com.tjoeun.shop.entity;

import java.time.LocalDateTime;

import com.tjoeun.shop.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  id : 		상품코드
  itemName : 상품이름
  price : 상품가격
  stockNumber : 상품재고
  itemDetail : 상품설명 
  itemSellStatus : 판매상태
  regTime : 등록시간
  updateTime : 수정시간
*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long id;

	@Column(nullable=false, length=50)
  private String itemName; 
	
	@Column(nullable=false)
  private int price;
	
	@Column(nullable=false)
  private int stockNumber; 
	
	@Lob
	@Column(nullable=false)
  private String itemDetail; 
	
	@Enumerated(EnumType.STRING)
  private ItemSellStatus itemSellStatus; 
	
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
  
}





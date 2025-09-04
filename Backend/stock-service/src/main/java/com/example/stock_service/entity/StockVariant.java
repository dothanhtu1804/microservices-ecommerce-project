package com.example.stock_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tgdd_stock_variants")
public class StockVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "sku")
    private String sku;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "storage")
    private String storage;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "slug")
    private String slug;

    @Lob
    @Column(name = "content")
    private String content;

    @Lob
    @Column(name = "attributes_detail")
    private String attributesDetail;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
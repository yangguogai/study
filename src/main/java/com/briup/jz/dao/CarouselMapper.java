package com.briup.jz.dao;

import com.briup.jz.bean.Carousel;
import com.briup.jz.bean.CarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarouselMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    long countByExample(CarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int deleteByExample(CarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int insert(Carousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int insertSelective(Carousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    List<Carousel> selectByExample(CarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    Carousel selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int updateByPrimaryKeySelective(Carousel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_carousel
     *
     * @mbg.generated Thu Jun 03 16:12:36 CST 2021
     */
    int updateByPrimaryKey(Carousel record);
}
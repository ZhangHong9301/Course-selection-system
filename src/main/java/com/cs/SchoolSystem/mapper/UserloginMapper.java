package com.cs.SchoolSystem.mapper;

import com.cs.SchoolSystem.po.Userlogin;
import com.cs.SchoolSystem.po.UserloginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserloginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    long countByExample(UserloginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int deleteByExample(UserloginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int insert(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int insertSelective(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    List<Userlogin> selectByExample(UserloginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    Userlogin selectByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int updateByExampleSelective(@Param("record") Userlogin record, @Param("example") UserloginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int updateByExample(@Param("record") Userlogin record, @Param("example") UserloginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int updateByPrimaryKeySelective(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated Thu Apr 12 16:47:33 CST 2018
     */
    int updateByPrimaryKey(Userlogin record);
}
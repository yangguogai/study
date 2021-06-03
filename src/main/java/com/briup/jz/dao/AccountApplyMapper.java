package com.briup.jz.dao;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountApplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    long countByExample(AccountApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int deleteByExample(AccountApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int insert(AccountApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int insertSelective(AccountApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    List<AccountApply> selectByExample(AccountApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    AccountApply selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByExampleSelective(@Param("record") AccountApply record, @Param("example") AccountApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByExample(@Param("record") AccountApply record, @Param("example") AccountApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByPrimaryKeySelective(AccountApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_apply
     *
     * @mbg.generated Wed Jun 02 22:44:48 CST 2021
     */
    int updateByPrimaryKey(AccountApply record);
}
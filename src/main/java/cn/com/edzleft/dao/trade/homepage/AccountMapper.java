package cn.com.edzleft.dao.trade.homepage;

import cn.com.edzleft.entity.Account;

/**
 * Created by ibmtech on 2017/11/16.
 */

public interface AccountMapper {

    /**
     * 根据账号查询用户信息
     */

    public Account findAccountByName(String  userName);
    /**
     * 根据账号查询用户是否存在
     * @param userName
     * @return
     */
    public Integer findByName(String  userName);
    
    
    /**
     *  添加一个用户账号信息
     */
    public int insertAccount(Account account);
    
    /**
     * 创建账号
     * @param account
     */
    public Integer insert(Account account);
    /**
     * 修改账号密码
     */
    public int updateMessage(Account loginer);

    /**
     * 更新用户信息
     */

    /**
     * 根据id查询用户信息
     */
    public Account selectAccountById(Integer id);
    //添加资料id
    int updataAccount(Account account);
}

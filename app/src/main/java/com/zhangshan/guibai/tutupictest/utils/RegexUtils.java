/* 
 *    Copyright 2012-2013 The Haohui Network Corporation 
 *    校验手机号 邮箱等的工具类
 */  
package com.zhangshan.guibai.tutupictest.utils;
  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
/** 
 * @project baidamei 
 * @create 2012-11-15 下午4:54:42 
 */  
public class RegexUtils {  
     /** 
     * 验证Email 
     * @param email email地址，格式：zhangsan@zuidaima.com，zhangsan@xxx.com.cn，xxx代表邮件服务商 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkEmail(String email) {   
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";   
        return Pattern.matches(regex, email);   
    }   
       
    /** 
     * 验证身份证号码 
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkIdCard(String idCard) {   
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";   
        return Pattern.matches(regex,idCard);   
    }   
       
    /** 
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港）） 
     * @param mobile 移动、联通、电信运营商的号码段 
     *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡） 
     *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p> 
     *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p> 
     *<p>电信的号段：133、153、180（未启用）、189</p> 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkMobilePhone(String mobile) {   
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";   
        return Pattern.matches(regex,mobile);   
    }   
       
    /** 
     * 验证固定电话号码 
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447 
     * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字， 
     *  数字之后是空格分隔的国家（地区）代码。</p> 
     * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号—— 
     * 对不使用地区或城市代码的国家（地区），则省略该组件。</p> 
     * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p> 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkPhone(String phone) {   
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";   
        return Pattern.matches(regex, phone);   
    }   
       
    /** 
     * 验证整数（正整数和负整数） 
     * @param digit 一位或多位0-9之间的整数 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkDigit(String digit) {   
        String regex = "\\-?[1-9]\\d+";   
        return Pattern.matches(regex,digit);   
    }   
       
    /** 
     * 验证整数和浮点数（正负整数和正负浮点数） 
     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkDecimals(String decimals) {   
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";   
        return Pattern.matches(regex,decimals);   
    }    
       
    /** 
     * 验证空白字符 
     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkBlankSpace(String blankSpace) {   
        String regex = "\\s+";   
        return Pattern.matches(regex,blankSpace);   
    }   
       
    /** 
     * 验证中文 
     * @param chinese 中文字符 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkChinese(String chinese) {   
        String regex = "^[\u4E00-\u9FA5]+$";   
        return Pattern.matches(regex,chinese);   
    }   
       
    /** 
     * 验证日期（年月日） 
     * @param birthday 日期，格式：1992-09-03，或1992.09.03 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkBirthday(String birthday) {   
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";   
        return Pattern.matches(regex,birthday);   
    }   
       
    /** 
     * 验证URL地址 
     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkURL(String url) {   
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";   
        return Pattern.matches(regex, url);   
    }   
      
    /** 
     * <pre> 
     * 获取网址 URL 的一级域名 
     * http://www.zuidaima.com/share/1550463379442688.htm ->> zuidaima.com 
     * </pre> 
     *  
     * @param url 
     * @return 
     */  
    public static String getDomain(String url) {  
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);  
        // 获取完整的域名  
        // Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);  
        Matcher matcher = p.matcher(url);  
        matcher.find();  
        return matcher.group();  
    }  
    /** 
     * 匹配中国邮政编码 
     * @param postcode 邮政编码 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkPostcode(String postcode) {   
        String regex = "[1-9]\\d{5}";   
        return Pattern.matches(regex, postcode);   
    }   
       
    /** 
     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小) 
     * @param ipAddress IPv4标准地址 
     * @return 验证成功返回true，验证失败返回false 
     */   
    public static boolean checkIpAddress(String ipAddress) {   
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";   
        return Pattern.matches(regex, ipAddress);   
    }   
    
    
    
    
    
    
    /*又一位前辈的*/
    /** 
     * 手机号校验 注：1.支持最新170手机号码 2.支持+86校验 
     *  
     * @param phoneNum 
     *            手机号码 
     * @return 验证通过返回true 
     */ 
    public static boolean isMobile(String phoneNum) {  
        if (phoneNum == null)  
            return false;  
        // 如果手机中有+86则会自动替换掉  
        return validation("^[1][3,4,5,7,8][0-9]{9}$",  
                phoneNum.replace("+86", ""));  
    }  
       
   
    /** 
     * 用户名校验,默认用户名长度至少3个字符，最大长度为15<br> 
     * 可修改正则表达式以实现不同需求 
     *  
     * @param username 
     *            用户名 
     * @return 
     */ 
    public static boolean isUserName(String username) {  
        /*** 
         * 正则表达式为：^[a-z0-9_-]{3,15}$ 各部分作用如下： [a-z0-9_-] ----------- 
         * 匹配列表中的字符，a-z,0–9,下划线，连字符 {3,15}-----------------长度至少3个字符，最大长度为15 
         * 如果有不同需求的可以参考以上修改正则表达式 
         */ 
        return validation("^[a-z0-9_-]{3,15}$", username);  
    }  
   
    /** 
     * 密码校验 
     * 要求6-16位数字和英文字母组合 
     * @param pwd 
     * @return 
     */ 
    public static boolean isPassword(String pwd) {  
        /** 
         * ^ 匹配一行的开头位置(?![0-9]+$) 预测该位置后面不全是数字 
         * (?![a-zA-Z]+$) 预测该位置后面不全是字母 
         * [0-9A-Za-z] {9,16} 由9-16位数字或这字母组成 
         */ 
        return validation("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{9,16}$", pwd);  
    }  
   
    /** 
     * 邮箱校验 
     *  
     * @param mail 
     *            邮箱字符串 
     * @return 如果是邮箱则返回true，如果不是则返回false 
     */ 
    public static boolean isEmail(String mail) {  
        return validation(  
                "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",  
                mail);  
    }  
       
   
    /** 
     * 正则校验 
     *  
     * @param pattern正则表达式 
     * @param str 
     *            需要校验的字符串 
     * @return 验证通过返回true 
     */ 
    public static boolean validation(String pattern, String str) {  
        if (str == null)  
            return false;  
        return Pattern.compile(pattern).matcher(str).matches();  
    } 
       
}
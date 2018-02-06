package com.zc.exer;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 比如有类User
User有两个字段 id，oldId 都是String类型
由于系统的历史原因，id表示当前系统用户id，oldId表示之前历史系统中遗留用户迁移过来的id，
在系统迁移后的一段时间中，
某用户可能只在新系统中存在，只有id
某用户可能只在老系统中存在，只有oldId
某用户可能既在老系统中存在，也在新系统中存在，即既有id，也有oldId
老系统中的oldId是8位   比如  00000086
新系统中的id是10位   如果从老系统中迁移过来的用户在前面补00
那么如果有两个User对象  u1 u2
u1的id是0000000086  u2 的oldId是00000086

 * @author  zc
 * @version  [版本号, 2017年2月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class User
{
    //10位 oldId则前面补00
    private String id;
    //8位 00000086
    private String oldId;
    //u1的id是0000000086  u2 的oldId是00000086
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(obj==this)
            return true;
        if(obj.getClass()!=User.class)
            return false;
        
        User other=(User)obj;
        //other没有新id
        if(other.getId()==null){
            //other也没有oldId
            if(other.getOldId()==null){
                return false;
            }
            //other有oldId.与this比较
            if(this.getId()==null&&this.getOldId()==null){
                return false;
            }
            if(this.getOldId()!=null){//当前用户的oldId与other比较
                return this.getOldId().equals(other.getOldId());
            }
            if(this.getId()!=null){//当前用户的新id 与 other比较
                return this.getId().substring(2).equals(other.getOldId());
            }
            return false;
        }
        //other有新id
        if(this.getId()==null&&this.getOldId()==null){
            return false;
        }
        if(this.getId()!=null){//当前用户的Id与other比较
            return this.getId().equals(other.getId());
        }
        if(this.getOldId()!=null){//当前用户的oldId 与 other比较
            return this.getOldId().equals(other.getId().substring(2));
        }
        return false;
    }
    
    
    public String getId()
    {
        return id;
    }


    public void setId(String id)
    {
        this.id = id;
    }


    public String getOldId()
    {
        return oldId;
    }


    public void setOldId(String oldId)
    {
        this.oldId = oldId;
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((oldId == null) ? 0 : oldId.hashCode());
        return result;
    }
}

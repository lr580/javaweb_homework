package cn.edu.scnu.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.edu.scnu.pojo.Product;
import cn.edu.scnu.pojo.User;
@Repository
@Mapper
public interface ProductMapper extends BaseMapper<Product>{
}

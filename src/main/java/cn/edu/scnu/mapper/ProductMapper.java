package cn.edu.scnu.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.edu.scnu.po.Product;
import cn.edu.scnu.po.User;
@Repository
@Mapper
public interface ProductMapper extends BaseMapper<Product>{

}

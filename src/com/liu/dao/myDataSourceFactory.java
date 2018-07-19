package com.liu.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class myDataSourceFactory extends UnpooledDataSourceFactory {
   public myDataSourceFactory() {
      this.dataSource = new ComboPooledDataSource("mysqlId");
   }
}

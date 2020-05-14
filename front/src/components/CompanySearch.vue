<template>
  <div id="a" style="margin:0 auto;width: 60%;">
    <div style="color: #409EFF;text-align:center">
      <el-image
        style="width: 100px; height: 50px"
        :src="logoUrl"
        fit="contain"></el-image>
      <div style="text-align:center;">
          <span style="color: cadetblue">
            小朗搜
          </span>
        【专注上海地区公司查名，暂不支持其它地区查名】
      </div>
    </div>
    <el-input placeholder="公司名称" v-model="input3" class="input-with-select">
      <el-select v-model="provinceCode" slot="prepend" placeholder="请选择">
        <el-option label="上海" value="shanghai"></el-option>
      </el-select>
      <el-button slot="append" icon="el-icon-search"></el-button>
    </el-input>

    <div style="margin-top: 15px;">
      <el-card class="box-card" style="margin-top: 2%">
       <span style="color: #409EFF;">
        该名称注册成功率{{successRate}}%
      </span>
        <el-progress :text-inside="true" :stroke-width="24" :percentage="successRate" status="success"></el-progress>
        <el-table
          :data="companies"
          style="width: 100%">
          <el-table-column
            prop="Name"
            label="公司名称"
            width="180">
          </el-table-column>
          <el-table-column
            prop="OperName"
            label="法人名称"
            width="180">
          </el-table-column>
          <el-table-column
            prop="Status"
            label="公司状态">
          </el-table-column>
          <el-table-column
            prop="StartDate"
            label="成立日期">
          </el-table-column>
        </el-table>

        <div class="block">
          <el-pagination
            layout="prev, pager, next"
            :total="1000">
          </el-pagination>
        </div>
      </el-card>

    </div>
    <span>
      本网站及技术由<span style="color: #409EFF">上海展东投资管理有限公司</span>提供
    </span>
  </div>
</template>

<script>
    import logoUrl from '@/assets/xl.png'

    export default {
        name: "CompanySearch",
        data() {
            return {
                logoUrl: logoUrl,
                successRate: 85,
                adShow: false,
                provinceCode: 'shanghai',
                companies: [{
                    Name: '上海启动有限公司',
                    OperName: '王小虎',
                    Status: '在职',
                    StartDate: '2016-05-04'
                }, {
                    Name: '上海启动有限公司',
                    OperName: '王小虎',
                    Status: '在职',
                    StartDate: '2016-05-04'
                }, {
                    Name: '上海启动有限公司',
                    OperName: '王小虎',
                    Status: '在职',
                    StartDate: '2016-05-04'
                }, {
                    Name: '上海启动有限公司',
                    OperName: '王小虎',
                    Status: '在职',
                    StartDate: '2016-05-04'
                }]
            }
        }
    }
</script>

<style>
  .el-select .el-input {
    width: 130px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }

  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 100%;
  }
</style>

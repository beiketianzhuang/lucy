<template>
  <div id="a" style="margin:0 auto;width: 60%;">

    <div style="color: #409EFF;text-align:center">
      <el-image
        style="width: 140px; height: 60px"
        :src="logoUrl"
        fit="contain">
      </el-image>
      <div style="text-align:center;">
          <span style="color: cadetblue">
            小朗搜
          </span>
        【专注上海地区公司查名，目前仅支持上海】
      </div>

    </div>
<!--    <el-form :inline="true" :model="queryObject" class="demo-form-inline">-->
<!--      <el-form-item size="large">-->
<!--        <el-select v-model="provinceCode">-->
<!--          <el-option label="上海" value="SH"></el-option>-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item size="large" label-width="200px">-->
<!--        <el-input v-model="queryObject.keyword" placeholder="公司名称"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item size="large">-->
<!--        <el-input v-model="queryObject.phone" placeholder="手机号"></el-input>-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" @click="queryCompanies">查询</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->
    <el-input style="margin-top: 2%" placeholder="公司名称" v-model="keyword" class="input-with-select">
      <el-select v-model="provinceCode" slot="prepend" placeholder="请选择">
        <el-option label="上海" value="SH"></el-option>
      </el-select>
      <el-button slot="append" @click="queryCompanies" icon="el-icon-search"></el-button>
    </el-input>

    <div style="margin-top: 15px;">
      <el-card v-show="show" class="box-card" style="margin-top: 2%">
        <div slot="header" class="clearfix">
          <div @click="showAd()">注册上海公司>><a href="#">联系我们(请点击)</a></div>
          <span style="color: brown;font-size: 20px">
              该名称注册成功率{{successRate}}%
            </span>
        </div>

        <el-progress style="margin-bottom: 3%" :text-inside="true" :stroke-width="24" :percentage="successRate"
                     status="success"></el-progress>
        <div class="infinite-list" v-infinite-scroll="load" style="overflow:auto">
          <el-table
            :data="companies.slice((currentPage-1)*pageSize,currentPage*pageSize)"
            style="width: 100%">
            <el-table-column
              prop="name"
              label="公司名称"
              width="180">
            </el-table-column>
            <el-table-column
              prop="operName"
              label="法人名称"
              width="180">
            </el-table-column>
            <el-table-column
              prop="status"
              label="公司状态">
            </el-table-column>
            <el-table-column
              prop="startDate"
              label="成立日期">
            </el-table-column>
          </el-table>
        </div>


        <div class="block">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[10, 20, 30]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total=parseInt(total)>
          </el-pagination>
        </div>
      </el-card>
    </div>

    <el-dialog
      title="上海展东投资管理有限公司"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <el-form ref="form" :model="contactUs" label-width="80px">
        <el-form-item label="联系人:">
          <span>{{contactUs.name}}</span>
        </el-form-item>
        <el-form-item label="联系电话:">
          <span>{{contactUs.phone}}</span>
        </el-form-item>
        <el-form-item label="微信:">
          <span>{{contactUs.wechat}}</span>
        </el-form-item>
        <el-form-item label="网站:">
          <a :href="contactUs.website" target="_blank">{{contactUs.website}}</a>
        </el-form-item>
        <el-form-item label="地址:">
          <span>{{contactUs.address}}</span>
        </el-form-item>
      </el-form>
      <span style="color: red">联系后请说明是通过小朗搜查名系统联系的</span>
      <span slot="footer" class="dialog-footer">
<!--      <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--      <el-button type="primary" @click="dialogVisible = false">确 定</el-button>-->
      </span>
    </el-dialog>
    <div style="margin-top: 30px;">
      本网站及技术由<span style="color: #409EFF"><a href="http://www.qgfuwu.com" target="_blank">上海展东投资管理有限公司</a></span>提供
    </div>
  </div>
</template>

<script>
    import logoUrl from '@/assets/xl.png'
    import axios from 'axios'

    export default {
        name: "CompanySearch",
        data() {
            return {
                load() {
                    this.count += 2
                },
                dialogVisible: false,
                show: false,
                keyword: "",
                logoUrl: logoUrl,
                successRate: 0,
                adShow: false,
                provinceCode: 'SH',
                companies: [],
                currentPage: 1,
                pageSize: 10,
                total: 0,
                contactUs: {
                    name: '陈经理',
                    phone: '18321687872',
                    wechat: '18321687872',
                    address: '上海市松江区文翔路1085号b门',
                    website: 'http://www.qgfuwu.com',
                    info: [],
                },
                queryObject: {
                    keyword: '',
                    phone: ''
                }
            }
        },
        methods: {
            queryCompanies() {
                axios.get("/companies/infos?keyword=" + this.keyword)
                    .then(resp => {
                        console.log(resp.data.results);
                        this.show = true;
                        this.companies = resp.data.results;
                        this.successRate = resp.data.successRate;
                        this.total = resp.data.results.length;
                        this.adShow = resp.data.adShow;
                    })
                    .catch(e => {

                    })
            },
            handleSizeChange(val) {
                this.pageSize = val;
            },
            handleCurrentChange(val) {
                this.currentPage = val;
            },
            handleClose(done) {
                done();
            },
            showAd() {
                this.dialogVisible = true;
            }
        },
        created() {
            console.log(this.dialogVisible);
        },
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

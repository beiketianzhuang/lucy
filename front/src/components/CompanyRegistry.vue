<template>
  <div>
    <el-card class="box-card">
      <div style="width: 50%">
        <el-form :model="registryCompanyForm" :rules="rules" ref="registryCompanyForm" label-width="100px"
                 class="demo-registryCompanyForm">
          <el-form-item label="地区" prop="address">
            <el-select v-model="registryCompanyForm.address" placeholder="请选择工商注册地区">
              <el-option label="上海" value="sh"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="注册类型" prop="businessType">
            <el-select v-model="registryCompanyForm.businessType" placeholder="请选择工商注册类型">
              <div v-for="businessType in businessTypes" :key="businessType.id">
                <el-option :label="businessType.name" :value="businessType.value"></el-option>
              </div>
            </el-select>
          </el-form-item>
          <el-form-item label="行业类型" prop="industry" style="width: 100%">
            <el-select v-model="registryCompanyForm.industry" placeholder="请选择工商注册类型">
              <div v-for="industry in industries" :key="industry.id">
                <el-option :label="industry.name" :value="industry.value"></el-option>
              </div>
            </el-select>
          </el-form-item>

          <el-form-item label="手机号" prop="region" style="width: 100%">
            <el-input v-model="registryCompanyForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="服务价格" style="width: 100%">
            <span style="color: #ff7800;font-size:30px;font-weight:bold;line-height:40px">¥{{price}}</span>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('registryCompanyForm')">立即申请</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>

    <el-card class="box-card" style="margin-top: 20px">
      <div slot="header" class="clearfix">
        <span>所需材料</span>
      </div>
      <div v-for="data in companyData" :key="data.number" class="text item">
        <div style="color: #999999">
          <span class="box-sizing">{{data.number}}</span>
          {{data.desc}}
        </div>
      </div>
    </el-card>
    <el-card class="box-card" style="margin-top: 20px">
      <div slot="header" class="clearfix">
        <span>注册流程</span>
      </div>
      <div v-for="data in companyRegistrySteps" :key="data.number" class="text item">
        <div style="color: #999999">
          <span class="box-sizing">{{data.number}}</span>
          {{data.desc}}
        </div>
      </div>
    </el-card>
    <el-card class="box-card" style="margin-top: 20px">
      <div slot="header" class="clearfix">
        <span>常见问题</span>
        <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
      </div>
      <el-collapse v-model="activeNames">
        <div v-for="question in companyQuestions" :key="question.id" class="text item">
          <el-collapse-item name="1">
            <template slot="title">
              <span class="Q"></span>{{question.question}}
            </template>
            <span class="A"></span>
            {{question.answer}}
          </el-collapse-item>
        </div>
      </el-collapse>
    </el-card>
  </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "CompanyRegistry",
        data() {
            return {
                price: 900,
                activeNames: ['1', '2', '3', '4', '5'],
                businessTypes: [],
                industries: [],
                companyData: [
                    {number: "01", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "02", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "03", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "04", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "05", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "06", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "07", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "08", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                ],
                companyRegistrySteps: [
                    {number: "01", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "02", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "03", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "04", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "05", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "06", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "07", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                    {number: "08", desc: "公司名称（地区+名字+行业+类型），例：上海企助网络信息科技有限公司"},
                ],
                companyQuestions: [
                    {
                        id: 1,
                        question: "公司注册流程是什么样的?",
                        answer: "流程很简单。。。。流程很简单。。。。流程很简单。。。。流程很简单。。。。流程很简单。。。。流程很简单。。。。流程很简单。。。。"
                    }
                ],
                registryCompanyForm: {
                    businessType: [],
                    industry: []
                },
                rules: {
                    name: [
                        {required: true, message: '请输入活动名称', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    industry: [
                        {required: true, message: '请选择行业类型', trigger: 'change'}
                    ],
                    businessType: [
                        {required: true, message: '请选择注册类型', trigger: 'change'}
                    ],
                    date2: [
                        {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
                    ],
                    type: [
                        {type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change'}
                    ],
                    resource: [
                        {required: true, message: '请选择活动资源', trigger: 'change'}
                    ],
                    desc: [
                        {required: true, message: '请填写活动形式', trigger: 'blur'}
                    ]
                },
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                }
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            }
        },
        created() {

            axios.get("/companies/registry/data")
                .then(resp => {
                    this.companyData = resp.data;
                })
                .catch(e => {

                })

            axios.get("/companies/registry/steps")
                .then(resp => {
                    this.companyRegistrySteps = resp.data;
                })
                .catch(e => {

                })

            axios.get("/companies/registry/questions")
                .then(resp => {
                    this.companyQuestions = resp.data;
                })
                .catch(e => {

                })

            axios.get("companies/commons/business-types")
                .then(resp => {
                    this.businessTypes = resp.data;
                })
                .catch(e => {

                })
            axios.get("companies/commons/industries")
                .then(resp => {
                    this.industries = resp.data;
                })
                .catch(e => {

                })
        }
    }
</script>

<style scoped>
  .box-sizing {
    display: inline-block;
    width: 32px;
    height: 28px;
    margin-right: 13px;
    padding-left: 6px;
    line-height: 28px;
    background: url(https://style.yuzhua.com/public/qy/images/service_detail/xuhao.png) no-repeat center;
    color: #ffffff;
    box-sizing: border-box;
  }

  .Q {
    position: relative;
    background: url(https://style.yuzhua.com/public/qy/images/service_detail/Q.png) no-repeat center;
    display: inline-block;
    width: 28px;
    height: 27px;
    margin-right: 10px;
  }

  .A {
    background: url(https://style.yuzhua.com/public/qy/images/service_detail/A.png) no-repeat center;
    display: inline-block;
    width: 28px;
    height: 27px;
    margin-right: 10px;
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 80%;
    margin: 0 auto;
  }
</style>

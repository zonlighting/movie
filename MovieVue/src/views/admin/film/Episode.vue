<template>
  <div>
    <v-row>
      <v-col>
        <v-card class="card">
           
          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title class="headline">
                Ranning Man <v-btn style="position: absolute; right: 10px; top: 10px" 
              >Edit</v-btn
            >
              </v-list-item-title>
              <v-list-item-subtitle> </v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
          <v-card-text>
            <v-row>
              <v-col>
                <div>Khởi chiếu : 20-10-2020</div>
                <div>Tập: 14/34</div>
                <div>Đạo diễn:Kim siêu Quần</div>
                <div>Trạng thái : Đang cập nhập</div>
                <div>Thể loại:Hài Hước</div>
                <div>Quốc gia: China</div>
                <div>Diễn viên:Kim Thần,Kim Thần</div>
                <div>Viewed:2023923</div>
                <div>
                  Rating:
                  <v-rating
                    style="display: inline-block"
                    background-color="purple lighten-3"
                    color="purple"
                    disabled
                    small
                  ></v-rating>
                </div>
                <div>
                  <v-row>
                    <v-col cols="12" sm="6"
                      ><v-avatar>
                        <img
                          src="https://cdn.vuetifyjs.com/images/john.jpg"
                          alt="John"
                        /> </v-avatar
                      >Kim Thần</v-col
                    ><v-col cols="12" sm="6">
                      <v-avatar>
                        <img
                          src="https://cdn.vuetifyjs.com/images/john.jpg"
                          alt="John"
                        /> </v-avatar
                      >Kim Thần
                    </v-col>
                  </v-row>
                </div>
              </v-col>
              <v-col>
                <v-img
                  lazy-src="https://picsum.photos/id/11/10/6"
                  max-width="350"
                  src="https://picsum.photos/id/11/500/300"
                ></v-img>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col>
        <v-card class="card">
          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-subtitle>Trainler </v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
          <div class="text-center">
            <video width="500px" height="240" controls>
              <source
                src="https://www.w3schools.com/html/movie.ogg"
                type="video/mp4"
              />
              <source
                src="https://www.w3schools.com/html/movie.ogg"
                type="video/ogg"
              />
              Your browser does not support the video tag.
            </video>
          </div>
        </v-card></v-col
      >
    </v-row>
    <v-card>
      <v-container>
        <v-row>
          <v-col cols="12" sm="3" v-for="i in 32" :key="i">
            <v-card style="height: 250px">
              <div>Tập {{ i }}</div>
              <template v-if="i < 5">
                <video
                  width="300px"
                  height="200"
                  controls
                  src="https://www.w3schools.com/html/movie.ogg"
                ></video>
                <v-btn style="position: absolute">Edit</v-btn>
              </template>
              <template v-else>
                <v-container
                  fluid
                  style="
                    height: 250px;
                    display: flex;
                    flex-direction: column;
                    justify-content: center;
                    align-items: center;
                  "
                >
                  <v-btn class="mx-2" fab dark color="indigo">
                    <v-icon dark> mdi-plus </v-icon>
                  </v-btn>
                </v-container>
              </template>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </div>
</template>
<script>
export default {
    data(){
        return{

        }
    },
    methods:{
       
    },
    created(){
        console.log(this.$route)
    }

}
</script>
<style scoped>
.card {
  height: 400px;
}
@media only screen and (max-width: 800px) {
  .card {
    height: 650px;
  }
}
</style>
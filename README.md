# MongoDB Spring Boot 示範專案 ⚡

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 專案介紹

這是一個展示 Spring Boot 與 MongoDB 整合的示範專案，主要用於教學和實務參考。專案演示了完整的 MongoDB CRUD 操作，以及自定義類型轉換器的實作。

### 🎯 專案特色

- ✅ 完整的 MongoDB CRUD 操作示範
- ✅ 自定義 Joda Money 類型轉換器實作
- ✅ Spring Data MongoDB 最佳實踐
- ✅ 實體對象與 MongoDB 文檔映射
- ✅ 使用 Lombok 簡化代碼
- ✅ MongoTemplate 直接操作示例

> 💡 **為什麼選擇此專案？**
> - 完整展示 MongoDB 與 Spring Boot 的整合方式
> - 提供實用的自定義轉換器範例
> - 演示 Joda Money 在 NoSQL 環境下的使用

## 技術棧

### 核心框架
- **Spring Boot 3.4.5** - 快速開發 Java 應用程式
- **Spring Data MongoDB** - MongoDB 資料存取框架
- **MongoDB** - NoSQL 資料庫系統

### 開發工具與輔助
- **Java 21** - 最新長期支援版本
- **Maven** - 專案建構工具
- **Lombok** - Java 程式碼簡化工具
- **Joda Money 2.0.2** - 貨幣處理函式庫

## 專案結構

```
mongo-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── tw/fengqing/spring/data/mongodemo/
│   │   │       ├── MongoDemoApplication.java    # 主應用程式類
│   │   │       ├── model/
│   │   │       │   └── Coffee.java             # 咖啡實體類
│   │   │       ├── converter/                  # 自定義轉換器
│   │   │       │   ├── MoneyReadConverter.java # Money 讀取轉換器
│   │   │       │   ├── MoneyWriteConverter.java# Money 寫入轉換器
│   │   │       │   └── MoneyLongReadConverter.java
│   │   │       └── config/
│   │   │           └── MongoConfig.java        # MongoDB 配置
│   │   └── resources/
│   │       └── application.properties          # 應用程式配置
│   └── test/
├── pom.xml                                    # Maven 配置檔案
└── README.md                                  # 專案說明文件
```

## 核心功能演示

### Coffee 實體類
專案定義了一個 `Coffee` 實體類，包含以下欄位：
- `id` - MongoDB 自動生成的唯一識別碼
- `name` - 咖啡名稱
- `price` - 使用 Joda Money 的價格欄位
- `createTime` - 建立時間
- `updateTime` - 更新時間

### CRUD 操作示例
主應用程式展示了完整的 CRUD 操作：

1. **創建 (Create)** - 儲存新的咖啡記錄
2. **讀取 (Read)** - 根據條件查詢咖啡記錄
3. **更新 (Update)** - 修改咖啡價格和更新時間
4. **刪除 (Delete)** - 移除咖啡記錄

### 自定義轉換器
專案實作了 Joda Money 類型的自定義轉換器，讓 MongoDB 能夠正確處理貨幣類型：
- `MoneyReadConverter` - 將 MongoDB 文檔轉換為 Money 對象
- `MoneyWriteConverter` - 將 Money 對象轉換為 MongoDB 文檔
- `MoneyLongReadConverter` - 處理長整型的 Money 轉換

## 快速開始

### 前置需求
- Java 21 或以上版本
- Maven 3.6+
- MongoDB 實例（本地或遠端）

### 安裝與執行

1. **啟動 MongoDB：**
```bash
# 使用 Docker 啟動 MongoDB
docker run -d --name mongo \
  -p 27017:27017 \
  -e MONGO_INITDB_ROOT_USERNAME=springbucks \
  -e MONGO_INITDB_ROOT_PASSWORD=springbucks \
  -e MONGO_INITDB_DATABASE=springbucks \
  mongo:latest
```

2. **建置專案：**
```bash
mvn clean compile
```

3. **執行應用程式：**
```bash
mvn spring-boot:run
```

### 預期輸出
執行成功後，您將看到類似以下的控制台輸出：
```
Coffee Coffee(id=..., name=espresso, price=TWD 100.00, createTime=..., updateTime=...)
Find 1 Coffee
Coffee Coffee(id=..., name=espresso, price=TWD 100.00, createTime=..., updateTime=...)
Update Result: 1
Update Result: Coffee(id=..., name=espresso, price=TWD 150.00, createTime=..., updateTime=...)
```

## 配置說明

### application.properties
```properties
# MongoDB 連線設定
spring.data.mongodb.uri=mongodb://springbucks:springbucks@localhost:27017/springbucks
```

### 環境變數支援
您可以使用環境變數來覆蓋配置：
```bash
export MONGO_HOST=localhost
export MONGO_PORT=27017
export MONGO_DB=springbucks
export MONGO_USER=springbucks
export MONGO_PASS=springbucks
```

## 最佳實踐與注意事項

### ⚠️ 重要提醒

| 項目 | 說明 | 建議做法 |
|------|------|----------|
| 資料庫連線 | MongoDB 認證設定 | 使用環境變數管理敏感資訊 |
| 效能優化 | 索引使用 | 根據查詢需求建立適當索引 |
| 類型轉換 | 自定義轉換器 | 實作雙向轉換邏輯 |
| 錯誤處理 | 異常管理 | 加入適當的錯誤處理機制 |

### 🔒 生產環境建議

- 啟用 MongoDB 認證與授權
- 配置連線池大小
- 實作健康檢查端點
- 加入日誌監控
- 使用 SSL/TLS 加密連線

## 擴展學習

### 進階主題
- MongoDB 索引策略
- Spring Data MongoDB Repository
- 響應式 MongoDB 操作
- MongoDB 事務處理
- 資料遷移與版本控制

### 相關專案
- `redis-demo` - Redis 緩存整合
- `jpa-demo` - JPA 關聯式資料庫操作
- `cache-demo` - Spring Cache 抽象層

## 參考資源

- [Spring Data MongoDB 官方文件](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [MongoDB 官方文件](https://docs.mongodb.com/)
- [Joda Money 文件](https://www.joda.org/joda-money/)
- [Lombok 使用指南](https://projectlombok.org/)

## 授權說明

本專案採用 MIT 授權條款，詳見 LICENSE 檔案。

## 關於作者

我們是一個專注於 Java 企業級應用開發的團隊，致力於提供高品質的技術解決方案和教學資源。

## 聯繫我們

- **部落格**：[風清雲談](https://blog.fengqing.tw/)
- **電子郵件**：[fengqing.tw@gmail.com](mailto:fengqing.tw@gmail.com)
- **GitHub**：[SpringMicroservicesCourse](https://github.com/SpringMicroservicesCourse)

---

**📅 最後更新：2025-01-20**  
**👨‍💻 維護者：風清雲談團隊**  
**🏷️ 版本：v1.1.0**
# DogeUI-NukkitPlugin

Nukkit-MOT 服务端插件，配合 DogeUI 资源包，实现与 BDS 完全一致的自定义菜单效果。

## 前置要求

- **Nukkit-MOT** 服务端（Java 17+）
- **DogeUI v1.0.0 资源包** → [GitHub 下载](https://github.com/DogeLakeDev/DogeUI)

## 安装

### 1. 配置 DogeUI 资源包

将 `DogeUI_v1.0.0` 文件夹放到 Nukkit-MOT 的 `resource_packs/` 目录下，然后在 `nukkit.yml` 中添加：

```yaml
resource-pack:
  enabled: true
  enforce: false
  resource-stack:
    - resource_packs/DogeUI_v1.0.0
```

### 2. 编译插件

```bash
cd DogeUINukkitPlugin
mvn clean package -DskipTests
```

### 3. 安装插件

将 `target/DogeUIPlugin-1.0.0.jar` 复制到 `plugins/` 目录，重启服务器。

## 功能

### 主菜单 (`/menu` 或 `/菜单`)

弹出 DogeUI 图片网格主菜单，12 个按钮完全对应资源包的自定义贴图：

| 位置 | 按钮 | 网格索引 |
|------|------|----------|
| 左上行 | 地图、守护者、北方冻原 | 0, 1, 2 |
| 左中行 | 传送、图书室 | 3, 4 |
| 左下行 | 设置、留言板、排行榜 | 5, 6, 7 |
| 右侧广告区 | 万能工具 | 8 |
| 右侧公告区 | 公告板 | 9 |
| 右侧边栏 | 拍照、信息 | 10, 11 |

### 欢迎弹窗

玩家进服 3 秒后自动弹出，点击"打开菜单"可直接进入主菜单。

### 消息对话框

所有子页面使用 `ModalForm` 弹窗，DogeUI 资源包自动覆写为自定义贴图样式。

## 原理

DogeUI 通过**标题前缀路由**机制实现自定义 UI 渲染：

```
服务端发送 ModalFormRequest 包
  → 客户端收到表单 JSON
    → DogeUI 资源包检查标题前缀
      → "/D "  → 使用 form_main 自定义图片网格布局
      → "/A "  → 使用 ad 广告面板布局
      → "/TEXT " → 使用 form_text 文字面板布局
      → 无前缀 → 标准 ModalForm（仍被 DogeUI 覆写样式）
```

**关键点：Nukkit-MOT 和 BDS 发送的是完全相同的 Bedrock 协议包，所以资源包的覆写效果完全一致。**

## 项目结构

```
DogeUINukkitPlugin/
├── pom.xml
├── src/main/java/top/szzz666/dogeui_plugin/
│   ├── Main.java                    # 插件主类
│   ├── command/
│   │   └── MenuCommand.java         # /menu 命令
│   ├── form/
│   │   ├── MainMenuForm.java        # 主菜单 (12 按钮网格)
│   │   └── easy_form/
│   │       ├── Simple.java          # SimpleForm 封装
│   │       └── Modal.java           # ModalForm 封装
│   └── listener/
│       └── JoinListener.java        # 进服欢迎监听
└── src/main/resources/
    └── plugin.yml
```

## 在其他插件中使用

```java


// 打开主菜单
MainMenuForm.show(player);

// 弹出欢迎弹窗
MainMenuForm.

showWelcome(player);
```

## 许可证

GPLv3

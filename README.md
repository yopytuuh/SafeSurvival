# 🛡️ SafeSurvival

**SafeSurvival** is a lightweight Paper plugin designed for private survival servers and groups of friends who want to ensure that nobody cheats, even if some players have OP permissions.

The plugin blocks a configurable list of vanilla commands that could be used to gain unfair advantages, while still allowing useful plugin commands such as `/home`, `/spawn`, `/warp`, etc.

---

## ✨ Features

* 🚫 Blocks configurable vanilla commands
* ⚙️ Fully configurable through `config.yml`
* 👑 Works even if players have OP permissions
* 📢 Broadcasts attempted uses of blocked commands
* 🔒 Supports namespaced commands (`minecraft:`, `bukkit:`, `paper:`, etc.)
* ⚡ Lightweight and optimized for Paper servers

---

## 📋 Example blocked commands

SafeSurvival can block commands such as:

* `/gamemode`
* `/give`
* `/gamerule`
* `/effect`
* `/enchant`
* `/summon`
* `/tp`
* `/teleport`
* `/time`
* `/weather`
* `/fill`
* `/setblock`
* `/execute`
* `/reload`
* `/debug`
* `/seed`

And many more.

---

## ⚙️ Configuration

All blocked commands can be enabled or disabled individually in `config.yml`.

Example:

```yaml
commands:
  gamemode: true
  give: true
  gamerule: true
  tp: false
  teleport: false
```

* `true` = command is blocked
* `false` = command is allowed

---

## 📢 Attempt Detection

When a player attempts to execute a blocked command, the command is cancelled and a message is broadcast to all online players:

```text
[!] yopytuuh tried this: /gamemode creative
```

This allows everyone on the server to know when someone attempted to use a forbidden command.

---

## 🔧 Installation

1. Download the latest release.
2. Place the `.jar` file into your server's `plugins` folder.
3. Start your server.
4. Edit the generated `config.yml` file if needed.
5. Restart or reload the server.

---

## 📦 Compatibility

- Spigot 1.8+
- Paper 1.8+ (recommended 1.20+ / 1.21+)
- Java 21+

*Tested on Paper 26.1.2*

---

## 📄 License

This project is released under the MIT License.

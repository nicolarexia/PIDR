package models.services

import com.google.inject._

import java.util.UUID
import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import models.User
import models.daos.UserDAO
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import play.api.i18n.Lang

/**
 * Handles actions to users.
 *
 * @param userDAO The user DAO implementation.
 */
class UserServiceImpl @Inject() (userDAO: UserDAO) extends UserService {

  /**
   * Retrieves a user that matches the specified login info.
   *
   * @param loginInfo The login info to retrieve a user.
   * @return The retrieved user or None if no user could be retrieved for the given login info.
   */
  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = userDAO.find(loginInfo)

  /**
   * Updates a user.
   *
   * @param user The user to update.
   * @return The updated user.
   */
  def update(user: User) = userDAO.update(user)

  /**
   * Saves the social profile for a user.
   *
   * If a user exists for this profile then update the user, otherwise create a new user with the given profile.
   *
   * @param profile The social profile to save.
   * @return The user for whom the profile was saved.
   */
  def save(profile: CommonSocialProfile, trackUser: Option[Boolean], preferredLang: Option[Lang]) = {
    userDAO.find(profile.loginInfo).flatMap {
      case Some(user: User) =>
        Future.successful(user)
      case _ => // Insert a new user
        var user = new User(
          gitID = "", // The gitID is generated by the server
          trackUser = trackUser,
          loginInfo = profile.loginInfo,
          firstName = profile.firstName,
          lastName = profile.lastName,
          fullName = profile.fullName,
          email = profile.email,
          preferredLang = preferredLang,
          lastProgLang = None,
          avatarURL = profile.avatarURL
        )
        userDAO.save(user).flatMap {
          case Some(userCreated: User) =>
            Future.successful(userCreated)
          case _ =>
            setError(true)
            Future.successful(user)
        }
    }
  }
}